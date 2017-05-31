package dev.empkiosk.page.eatplace;

public enum EatPlace {
    EAT_IN, TAKE_OUT;

    @Override
    public String toString() {
        return this.name();
    }
}
