Pod::Spec.new do |spec|

  spec.name         = "SampleCocoapods"
  spec.version      = "0.0.1"
  spec.summary      = "Pod for use with builded shared kmm lib"

  spec.homepage     = "https://github.com/zazzaze/KMM_FOR_SDK"
  spec.license      = "MIT"

  spec.author             = { "Egor Anikeev" => "egor.anikeev.00@gmail.com" }

  spec.swift_version = '5.2'
  spec.platform = :ios, '12'

  spec.source       = { :git => "https://github.com/zazzaze/KMM_FOR_SDK.git", :tag => "#{spec.version}" }

  spec.source_files  = "Sources/**/*.swift"

  spec.libraries = 'c++'
  spec.vendored_frameworks = 'Support/shared_cocoapods.xcframework'

end
