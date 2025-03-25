import Student from "./Student"

function Friends() {
    const newStyle = {
        border: '1px solid blue',
        padding: '10px',
        margin: '10px'
    }

    const personInfo = {
        profession: 'Friends'
    }

    const friends = [{ id: 1, name: 'Ajim', age: 20 }, { id: 2, name: 'Sahid', age: 10 }, { id: 3, name: 'Riad', age: 15 }]

    return (
        <div style={newStyle}>
            <h1>{personInfo.profession}: {friends.length}</h1>
            {friends.map((friend) => <Student key={friend.id} hasDetails={true} name={friend.name} age={friend.age} />)}
        </div>
    )

}

export default Friends