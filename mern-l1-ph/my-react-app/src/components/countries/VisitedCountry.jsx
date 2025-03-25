import PropTypes from "prop-types";
import "./Country.css";

function VisitedCountry({ country }) {
    const { flags } = country;

    return (
        <div>
            <img style={{ borderRadius: '40px' }} src={flags.png} alt={flags.alt} width={100} height={100} />
        </div>
    )
}

VisitedCountry.propTypes = {
    country: PropTypes.object.isRequired
}

export default VisitedCountry