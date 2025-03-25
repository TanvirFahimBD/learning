const getStoredCart = () => {
    const storedCartString = localStorage.getItem('cart');
    if (storedCartString) {
        return JSON.parse(storedCartString);
    } else {
        return [];
    }
}

const saveCartToLS = (cart) => {
    const cartStr = JSON.stringify(cart);
    localStorage.setItem('cart', cartStr);
}

const addCartToLS = (id) => {
    const cart = getStoredCart();
    cart.push(id);
    saveCartToLS(cart);
}

const removeCartToLS = (id) => {
    const cart = getStoredCart();
    if (cart.length) {         
        let newCart = cart.filter(ct => ct !== id);
        saveCartToLS(newCart);
    }
}


export {getStoredCart, addCartToLS, removeCartToLS}