class Solution {
public:
    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        vector<int> daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        auto dateToDay = [&](string date) {
            int month = stoi(date.substr(0, 2));
            int day = stoi(date.substr(3, 2));
            int totalDays = day;
            for (int i = 0; i < month - 1; ++i) {
                totalDays += daysInMonths[i];
            }
            return totalDays;
        };
        
        int aliceArrival = dateToDay(arriveAlice);
        int aliceLeave = dateToDay(leaveAlice);
        int bobArrival = dateToDay(arriveBob);
        int bobLeave = dateToDay(leaveBob);
        
        int latestArrival = max(aliceArrival, bobArrival);
        int earliestLeave = min(aliceLeave, bobLeave);
        
        return max(0, earliestLeave - latestArrival + 1);
    }
};