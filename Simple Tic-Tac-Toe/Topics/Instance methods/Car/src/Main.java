
class Car {
    final int oneStep = 5;
    int yearModel;
    String make;
    int speed;

    public void accelerate() {
        this.speed += oneStep;
    }

    public void brake() {
        if (this.speed < oneStep) {
            this.speed = 0;
        } else {
            this.speed -= oneStep;
        }
    }
}