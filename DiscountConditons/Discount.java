package DiscountConditons;

public class Discount {
    private boolean member = false;
    private String days;
    private double cost;
    private double discount;

    public Discount(String memberInput, String daysInput, double costInput) {
        if (memberInput.equals("true")) {
            member = true;
        }
        days = daysInput;
        cost = costInput;
    }

    public double computeDiscount() {
        if (member) { // Co-op member?
            if (days.equals("weekend")) { // Shopping on the weekend?
                if (cost < 200) { // Shopping cost less than 200?
                    discount = 0.025;
                    // return 0.025 * cost;
                } else { // Then it must be more than 200
                    discount = 0.05;
                    // return 0.05 * cost;
                }
            } else { // Then the shopping must be during the weekday
                if (cost < 200) { // Shopping cost less than 200?
                    discount = 0.05;
                    // return 0.05 * cost;
                } else { // Then it must be more than 200
                    discount = 0.1;
                    // return 0.1 * cost;
                }
            }
        } else { // Then must not be a member
            if (days.equals("weekend")) { // Working on the weekend?
                if (cost < 200) { // Shopping cost less than 200?
                    discount = 0;
                    // return 0;
                } else { // Then it must be more than 200
                    discount = 0.02;
                    // return 0.02 * cost;
                }
            } else { // Then the shopping must be during the weekday
                if (cost < 200) { // Shopping cost less than 200?
                    discount = 0.03;
                    // return 0.03 * cost;
                } else { // Then it must be more than 200
                    discount = 0.04;
                    // return 0.04 * cost;
                }
            }
        }
        // Version 2
        /*
         * if (member && days.equals("weekend") && cost < 200) { discount = 0.025; }
         * else if (member && days.equals("weekend") && cost >= 200) { discount = 0.05;
         * } else if (member && days.equals("weekday") && cost < 200) { discount = 0.05;
         * } else if (member && days.equals("weekday") && cost >= 200) { discount = 0.1;
         * } else if (!member && days.equals("weekend") && cost >= 200) { discount = 0;
         * } else if (!member && days.equals("weekend") && cost >= 200) { discount =
         * 0.02; } else if (!member && days.equals("weekday") && cost < 200) { discount
         * = 0.03; } else if (!member && days.equals("weekday") && cost >= 200) {
         * discount = 0.04; }
         */
        discount = discount * cost; // calculates the discount
        return discount;
    }
}
