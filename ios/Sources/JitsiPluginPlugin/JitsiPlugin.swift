import Foundation

@objc public class JitsiPlugin: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
