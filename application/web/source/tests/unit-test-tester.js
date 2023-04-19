function unitTest(description, functionPassedIn){
    try {
        functionPassedIn();
      console.log('\x1b[32m%s\x1b[0m', `[test passed] ${description} `);
    } catch (error) {
      console.log('\n');
      console.log('\x1b[31m%s\x1b[0m', `[test has failed] ${description} `);
      console.error(error);
    }
  };

  module.exports = unitTest;