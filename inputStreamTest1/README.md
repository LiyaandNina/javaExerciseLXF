# Example

This sample project demonstrates the integration and usage of the WIBU Compile Time Protector. It consists of a CMake project and dedicated solutions for Visual Studio and Xcode. 

The sample shows a simple fibonacci program which uses Basic Protection (license list 0) to bind the whole program to 6000010:13. Without this license it doesn't even start. 

Modular Licensing is used in order to protect the actual fibonacci algorithm in function *fib* . In the example License list 1 consists of a license 6000010:14. 

Additionally code obfuscation is activated to employ additional obfuscation techniques to hide the original intellectual property.

