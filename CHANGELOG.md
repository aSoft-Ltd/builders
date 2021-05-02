# 1.3.30 : 2021.05.02
- Added kotlin 1.5.0 support

# 1.3.20 : 2021.04.05
- Added application and library dsl
- Added macos targets
- Setup macos CI build
- Fixed publishing error to addition of sources

# 1.3.0 : 2021.01.01
- Added js application & library configurarions
- Added default testing support
- Fixed flakiness in picking up konfig files

# 1.2.0 : 2020.12.15
## New Features
- [x] Provide easy lib configurations
- [x] enable optional signgings
- [x] Add `aSoftOSSLibrary` and `aSoftCSSLibrary` together with `Library` functions
- [x] Add `kotlinx(module,version)` function
- [x] Add `maven(url = "https://kotlin.bintray.com/kotlinx/")` to publicRepos
- [x] make the `applikation` plugin add publicRepos automatically the same way the `library` plugin does
- [x] add `fun PluginDependenciesSpec.asoft(plugin: String) = id("tz.co.asoft.$plugin")`

# 1.0.0
## Build Src
- Updated to gradle version 6.7.1

## Bug Fixes
- Fixed: Cannot query the value of this property because it has no value available.

## Samples
- Updated samples

# 0.0.7
## Availability
- Published to gradle plugin portal

## Build Src
- Updated to gradle version 6.7

## New Features
- Added the `tz.co.asoft.library`
- Added the `tz.co.asoft.plugin.maker`
- Added the aSoftLibrary method

## Documentation
- Update readme

## Samples
- Updated samples