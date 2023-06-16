const fetchLoginFailures = async (path) => {
	const response = await fetch(path);
	const text = await response.text();
	return aggregateFaliuresByDate(getDatesArray(text));
};
const getDatesArray = (str) => {
	const array = str.split("\n").reverse();
	const datesOnly = array.map((failure) => failure.split(" ", 1)[0]);
	return datesOnly.filter((date) => date !== "");
};

const aggregateFaliuresByDate = (datesArray) => {
	const failureMap = new Map();
	
	datesArray.forEach((date) => {
		if (failureMap.has(date)) {
			const failureCount = failureMap.get(date);
			failureMap.set(date, failureCount + 1);
		} else {
			failureMap.set(date, 1);
		}
	});

	return failureMap;
};

export function getFileNotFoundMessage(fileContentData) {
	return fileContentData.includes("</html") ? "Sorry, I could not find that log" : "";
}

export default fetchLoginFailures;
