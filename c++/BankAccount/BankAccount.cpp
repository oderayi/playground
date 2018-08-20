#include<iostream>
#include<string>
#include "BankAccount.h"

using namespace std;
		
		BankAccount::BankAccount(){
			cout << "BankAccount constructor" << endl;
		}
		bool BankAccount::open(){
			status = BankAccount::STATUS_ACTIVE;
			cout << "Account opened successfully." << endl;
			return true;
		}
		
		bool BankAccount::close(){
			status = BankAccount::STATUS_CLOSED;
			cout << "Account closed successfully." << endl;
			return true;
		}
	
		bool BankAccount::suspend(){
			status = BankAccount::STATUS_SUSPENDED;
			cout << "Account suspended successfully." << endl;
			return true;
		}
		
		void BankAccount::deposit(double amount){
			balance += amount;
			cout << amount << " was deposited successfully." << endl;
		}
		
		void BankAccount::withdraw(double amount){
			balance -= amount;
			cout << amount << " was withdrawn successful." << endl;
		}
		
		void BankAccount::showBalance(){
			cout << "Balance is: " << balance << endl;
		}
		
		void BankAccount::showSummary(){
			cout << "Account ID: " << id << endl
				 <<	"Account Code: " << accountCode << endl
				 << "Customer ID: " << customerId << endl
				 << "Account Balance: " << balance << endl
				  << "Status: " << interpretStatus(status) << endl;
		}
	
		string BankAccount::interpretStatus( int _status ){
			switch(_status){
				case BankAccount::STATUS_ACTIVE:
					return "Active";
					break;
				case BankAccount::STATUS_INACTIVE:
					return "Inactive";
					break;
				case BankAccount::STATUS_SUSPENDED:
					return "Suspended";
					break;
				case BankAccount::STATUS_CLOSED:
					return "Closed";
					break;
			}
		}

		
		

