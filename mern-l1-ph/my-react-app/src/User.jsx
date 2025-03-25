/* eslint-disable react/prop-types */
function User({ user }) {
    const newStyle = {
        border: '1px solid red',
        padding: '10px',
        margin: '10px'
    }
    const { name, email } = user;

    return (
        <div style={newStyle}>
            <p>Name: {name}</p>
            <p>Email: {email}</p>
        </div>
    )
}

export default User