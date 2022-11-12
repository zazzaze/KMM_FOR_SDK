#!/bin/bash
set -e

function setup_xcframework {
	cd $1
	./gradlew buildReleaseXCFramework
	cd ../
}

setup_xcframework KMMSharedCode
setup_xcframework KMMSharedCodeCocoapods
setup_xcframework KMMSharedCodeLower
setup_xcframework KmmSharedMain

echo "Copying cocoapods xcframework"
cp -r kmm_xcframework/Release/shared_cocoapods.xcframework SamplePackage/Support

echo "Installing cocoapods to poject"
cd SamplePackage/Example/Demo
pod install
cd ../../../
