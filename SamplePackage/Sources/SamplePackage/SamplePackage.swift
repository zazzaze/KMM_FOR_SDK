#if SWIFT_PACKAGE
import shared
#elseif COCOAPODS
import shared_cocoapods
#endif

public struct SamplePackage {
    public private(set) var text = "Hello, World!"

    public init() {
    }
}
