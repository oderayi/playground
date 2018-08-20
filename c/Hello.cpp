#include <iostream>
#include <string>
using namespace std;

int main(){
	string age;
	string name;
	cout << "Enter an integer: ";
	getline(cin, age);
	cout << "Enter a string: ";
	getline(cin, name);
	cout << "Hello C++, you're " << age << " years old today." << endl;
	cout << "Your new name is " << name;
	return 0;
}
