#if SWIFT_PACKAGE
import shared
#elseif COCOAPODS
import shared_cocoapods
#endif

public struct SampleClass {
    public let text: String

    public init() {
        text = Greeting().greeting()
    }
}
