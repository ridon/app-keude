#!/bin/bash -ex

EXTERN=../extern

place_support_v4() {
    mkdir -p $1/libs
    cp libs/android-support-v4.jar $1/libs/
}

android update lib-project --path $EXTERN/UniversalImageLoader/library --target android-21

android update lib-project --path $EXTERN/AndroidPinning --target android-21

android update lib-project --path $EXTERN/MemorizingTrustManager --target android-21

android update lib-project --path $EXTERN/libsuperuser/libsuperuser --target android-21

android update lib-project --path $EXTERN/zxing-core --target android-21

android update lib-project --path $EXTERN/android-support-v4-preferencefragment --target android-21
place_support_v4 $EXTERN/android-support-v4-preferencefragment

android update lib-project --path $EXTERN/Support/v7/appcompat --target android-21
place_support_v4 $EXTERN/Support/v7/appcompat

android update project --path . --name F-Droid --target android-21

{ echo -e "\nSuccessfully updated the main project.\n"; } 2>/dev/null

# technically optional, needed for the tests
cd test
android update test-project --path . --main ..

{ echo -e "\nSuccessfully updated the test project.\n"; } 2>/dev/null
