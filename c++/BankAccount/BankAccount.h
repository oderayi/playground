#ifndef BANK_ACCOUNT_H
#define BANK_ACCOUNT_H
#include<string>
using namespace std;
class BankAccount {
	static const int STATUS_ACTIVE = 0;
	static const int STATUS_INACTIVE = 1;
	static const int STATUS_SUSPENDED = 2;
	static const int STATUS_CLOSED = 3;
	
	unsigned int id;
	unsigned int customerId;
	string accountCode;
	double balance;
	bool status;
	
	public:
		BankAccount();
		bool open();
		bool close();
		bool suspend();
		void deposit(double amount);
		void withdraw(double amount);
		void showBalance();
		void showSummary();
		
	private:
		string interpretStatus( int _status );
};

#endif //BANK_ACCOUNT_H
