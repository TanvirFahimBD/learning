{

//* 2-9: Nullable, Unknown and Never Types
    
/**
 * ? Null type - used by intersection otherwise directly not check possible
 */
const searchName = (value: string | null) => {
  if (value === null) {
    console.log("nothing to search");
  } else {
    console.log("Searching ...");
  }
};

// searchName("Search this")
searchName(null)

/**
 * ? Unknown type - when type is not known before then check by typeof
 */
const getMyCarSpeed = (speed: unknown) => {
  if (typeof speed === "number") {
    const convertedSpeed = (speed * 1000) / 3600;
    console.log(`My speed is ${convertedSpeed}`);
  }
  else if (typeof speed === "string") {
    const [value, unit] = speed.split(" ");
    const convertedSpeed = (parseInt(value) * 1000) / 3600;
    console.log(`My speed is ${convertedSpeed} ${unit}`);
  }
  else {
    console.log("wrong type");
  }
};
    
getMyCarSpeed(10);
getMyCarSpeed("10 kmh^-1");
getMyCarSpeed(false);

/**
 * ? never type - never type is used during throw error. never return ever just throw error
 */
function throwError(message: string): never {
  throw new Error(message);
}

throwError("Error occured ........");
    
}