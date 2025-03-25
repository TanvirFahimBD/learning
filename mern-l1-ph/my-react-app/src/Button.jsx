/* eslint-disable react/prop-types */
import { useState } from "react"

function Button({ fnc1, fnc2, children, name, stg1, stg2 }) {
    const [count, setCount] = useState(0);

    const handleCount = (count, isIncrease, name) => {
        if (isIncrease == true) {
            setCount(count => count + 1);
            fnc1(name);
        } else {
            if (count > 0) {
                setCount(count => count - 1);
                fnc2(name);
            }
        }
    }

    return (
        <>
            <button onClick={() => handleCount(count, true, name)}>{stg1} {children}</button>
            <button onClick={() => handleCount(count, false, name)}>{stg2} {children}</button>
            <p>Total Message: {count}</p>
        </>
    )
}
export default Button