import { useState } from "react"
import { useEffect } from "react"
import User from "./User";

function Users() {
    const newStyle = {
        border: '1px solid red',
        padding: '10px',
        margin: '10px'
    }

    const [users, setUsers] = useState([]);

    useEffect(() => {
        fetch('https://jsonplaceholder.typicode.com/users')
            .then(res => res.json())
            .then(data => setUsers(data))
    }, [])


    if (users.length > 0) {
        return (
            <>
                <p>Total user: {users.length}</p>
                <div style={newStyle}>
                    {
                        users.map(user => <User key={user.id} user={user} />)
                    }
                </div>
            </>
        )
    } else {
        return <p>Loading...</p>
    }
}

export default Users