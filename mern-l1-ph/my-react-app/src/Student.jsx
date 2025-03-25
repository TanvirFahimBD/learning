/* eslint-disable react/prop-types */
import Button from "./Button";

function Student({ hasDetails, age, name }) {
    const newStyle = {
        border: '1px solid red',
        padding: '10px',
        margin: '10px'
    }

    const studentInfo = {
        profession: 'Student'
    }
    const handleMessageSend = (name) => {
        alert(`Message Send to ${name}`);
    }

    const handleMessageBack = (name) => {
        alert(`Message Back from ${name}`);
    }

    if (hasDetails == true) {
        return (
            <div style={newStyle}>
                <h1>{studentInfo.profession}</h1>
                <p className='borderNew'>Name: {name}, Age: {age} </p>
                <Button name={name} fnc1={handleMessageSend} fnc2={handleMessageBack} stg1="Send" stg2="Remove" >
                    Message to {name}
                </Button>
            </div>
        )
    } else {
        return (
            <div style={newStyle}>
                <h1>Profession: {studentInfo.profession}</h1>
                <p className='borderNew'>Details coming soon... </p>
            </div>
        )
    }


}

export default Student