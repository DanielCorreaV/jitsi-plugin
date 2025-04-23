// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "JitsiPlugin",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "JitsiPlugin",
            targets: ["JitsiPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "JitsiPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/JitsiPluginPlugin"),
        .testTarget(
            name: "JitsiPluginPluginTests",
            dependencies: ["JitsiPluginPlugin"],
            path: "ios/Tests/JitsiPluginPluginTests")
    ]
)