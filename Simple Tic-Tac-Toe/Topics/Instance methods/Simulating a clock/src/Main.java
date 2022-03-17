
class Clock {
    final int maxMinute = 59;
    final int maxHour = 12;
    int hours = maxHour;
    int minutes = 0;

    public void next() {

        if (this.minutes == maxMinute && this.hours == maxHour) {
            this.minutes = 0;
            this.hours = 1;
        } else if (this.minutes == maxMinute && this.hours < maxHour) {
            this.minutes = 0;
            this.hours++;
        } else {
            this.minutes++;
        }
        // implement me
    }
}