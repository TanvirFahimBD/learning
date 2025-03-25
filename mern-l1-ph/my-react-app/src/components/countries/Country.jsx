import { useState } from "react";
import PropTypes from "prop-types";
import "./Country.css";

function Country({ country, fnc }) {
    const newStyle = {
        border: '1px solid blue',
        padding: '10px',
        margin: '10px',
        borderRadius: '5px'
    }
    const { name, population, flags } = country;

    const [booked, setBooked] = useState(false);

    const handleBook = () => {
        setBooked(!booked);
        fnc(country);
    }

    return (
        <div style={newStyle}>
            <img style={{ borderRadius: '40px' }} src={flags.png} alt={flags.alt} width={200} height={150} />
            <p>{name.common}</p>
            <p>Population: {population}</p>

            <button onClick={() => handleBook()}>{booked == true ? "Cancel the ticket" : "Book a ticket"}</button>
            <p className={booked == true ? "green-bg" : "red-bg"}>{booked == true ? "You have booked a ticket" : "Not booked a ticket yet"}</p>
        </div>
    )
}

Country.propTypes = {
    country: PropTypes.object.isRequired,
    fnc: PropTypes.func.isRequired
};

export default Country