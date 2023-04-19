function strictEqual(actual, expected) {
	if (actual !== expected) {
		throw new Error(`Actual: ${actual}, Expected: ${expected}`);
	}
}

module.exports = strictEqual;
