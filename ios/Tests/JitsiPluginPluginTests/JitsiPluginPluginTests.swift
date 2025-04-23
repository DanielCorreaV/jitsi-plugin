import XCTest
@testable import JitsiPluginPlugin

class JitsiPluginTests: XCTestCase {
    func testEcho() {
        // This is an example of a functional test case for a plugin.
        // Use XCTAssert and related functions to verify your tests produce the correct results.

        let implementation = JitsiPlugin()
        let value = "Hello, World!"
        let result = implementation.echo(value)

        XCTAssertEqual(value, result)
    }
}
