package edu.problems.arrays1d;

/**
 * 
 * Circular Array
 * 
 * Program to find the Starting bank- A bank from where he can start his travel
 * with associated account balances and spend mentioned amount to travel to next
 * bank in a circular fashion and reaches bank to starting bank
 * 
 * 4 banks we have (b1, b2, b3, b4) connected cirularly
 * 
 * if he/she starts at b2 and reaches back b2 after visiting all bank in
 * circular fashion(b2->b3->b4->b1->b2) with 0 or +ve balance then b2 is the
 * output if unable to start at any bank then return -1
 * 
 */
public class CircularBank {

	public int findStartingBank(int balance[], int pay[]) {
		if (null == balance || null == pay || balance.length != pay.length)
			return -1;

		int currBank = 0;

		while (currBank < balance.length) {
			int startBank = currBank;
			int currBalance = 0;

			for (int i = currBank; i < currBank + balance.length; i++) {
				currBalance += balance[i % balance.length]; // Add money from current bank with previous balance
				currBalance -= pay[i % balance.length]; // Pay money for travel
				if (currBalance < 0) {
					currBank = i + 1; // Next Starting bank
					break;
				}
			}
			if (currBalance >= 0)
				return startBank;
		}
		return -1;
	}

	public static void main(String[] args) {

		int balance[] = { 1, 25, 6, 40 };
		int pay[] = { 10, 30, 8, 15 };

		CircularBank cb = new CircularBank();
		int st = cb.findStartingBank(balance, pay);
		System.out.println(st);

	}

}
