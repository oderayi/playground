#include<iostream>
#include<string>
#include "BankAccount.cpp"

using namespace std;

int main(){
	BankAccount bankAccount = BankAccount();
	bankAccount.open();
	bankAccount.deposit(23000.00);
	bankAccount.withdraw(10000.00);
	bankAccount.showBalance();
	bankAccount.showSummary();
}
