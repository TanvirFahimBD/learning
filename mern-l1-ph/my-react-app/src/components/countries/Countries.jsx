import { useState } from "react"
import { useEffect } from "react"
import Country from "./Country";
import "./Country.css";
import { addCartToLS, getStoredCart, removeCartToLS } from "../../utilities/localStorage";
import VisitedCountry from "./VisitedCountry";

function Countries() {
    const [countries, setCountries] = useState([]);
    const [visitedCountries, setVisitedCountries] = useState([]);

    useEffect(() => {
        fetch('https://restcountries.com/v3.1/all')
            .then(res => res.json())
            .then(data => {
                setCountries(data)
            })
    }, [])

    useEffect(() => {
        const cartData = getStoredCart();
        const prevVisitedCountries = countries.filter(cnt => cartData.includes(cnt.cca3));
        setVisitedCountries(prevVisitedCountries);
    }, [countries])

    const handleVisitedCountry = (cnt) => {
        let exists = visitedCountries.find(vc => cnt.name.common == vc.name.common);

        if (exists) {
            let newCountries = [...visitedCountries].filter(vc => vc.name.common !== cnt.name.common)
            setVisitedCountries(newCountries);
            removeCartToLS(cnt.cca3);
        } else {
            let newCountries = [...visitedCountries, cnt];
            setVisitedCountries(newCountries);
            addCartToLS(cnt.cca3);
        }
    }

    if (countries.length > 0) {
        return (
            <>
                <h4>Total country: {countries.length}</h4>
                <h4>Total visited: {visitedCountries.length}</h4>
                <div className="country-container">
                    {
                        visitedCountries.map(country => <VisitedCountry key={country.cca3} country={country} />)
                    }
                </div>
                <div className="country-container">
                    {
                        countries.map(country => <Country key={country.cca3} country={country} fnc={handleVisitedCountry} />)
                    }
                </div>
            </>
        )
    } else {
        return <p>Loading...</p>
    }
}

export default Countries