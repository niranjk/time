// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "OpenLink",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "OpenLink",
            targets: ["OpenLink"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "OpenLink",
            path: "./OpenLink.xcframework"
        ),
    ]
)
