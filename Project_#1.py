#This program will estimate the cost of a rental car service
import math
print("Welcome to Osprey car rentals.\n")

#Inform customer about inputs and then ask to continue.
print("At the prompts, please enter the following:")
print("\tCustomer's classification code (a character: BDW)")
print("\tNumber of days the vehicle was rented (int)")
print("\tOdometer reading at the start of the rental period (int)")
print("\tOdometer reading at the end of the rental period (int)\n")

#Ask if customer wants to continue and while loop for if customer watns to continue.
should_continue = input("Would you like to continue (Y/N) ?: ")
while should_continue == "y" or should_continue == "Y":
    customer_code = input("\nCustomer code (BDW): ")
    #This is while loop to weed out invalid customer codes.
    while customer_code != "B" and customer_code != "D" and customer_code != "W":
        #Display Error message.
        print("\n\t**** Invalid customer code. Try again. ****")
        #Reassign for new input.
        customer_code = input("\nCustomer Code (BDW): ")

        #Get customer's rental info.
    days = int(input("\nNumber of days rented: "))
    raw_start_odometer = int(input("Starting odometer reading: "))
    raw_end_odometer = int(input("End odometer reading: "))
        
    #Convert odometer reding into decimal form
    start_reading = int(raw_start_odometer) / 10
    end_reading = int(raw_end_odometer) / 10

    #Get a fraction and absolute value for weeks
    num_weeks_fraction = days / 7
    num_weeks_absolute = math.ceil(num_weeks_fraction)

    #Calculate the miles driven by subtracting end reading by start
    if end_reading >= start_reading:
        miles_driven = end_reading - start_reading
    #This calculates miles driven when the odometer surpasses 6 digits and restarts
    else:
        miles_driven = (100000 - start_reading) + end_reading

    #Calculate average miles per day
    avg_miles_per_day = miles_driven / days

    #Calculate the fraction and absolute value for average miles per week
    avg_miles_per_week_fraction = miles_driven / num_weeks_fraction
    avg_miles_per_week_absolute = miles_driven / num_weeks_absolute

    #When customer enters code B it triggers this set of computation
    if customer_code == "B":
        base_charge = 40 * days
        mile_charge = 0.25 * miles_driven
        amount_due = base_charge + mile_charge
        
    #When customer enters code D it triggers this set of computation
    elif customer_code  == "D":
        if avg_miles_per_day <= 100:
            amount_due = 60 * days
        else:
            amount_due = 60 * days + 0.25 * ((avg_miles_per_day - 100) * days)

    #When customer enters code W it triggers this set of computation
    elif customer_code == "W":
        if avg_miles_per_week_absolute < 900 :
            amount_due = num_weeks_absolute * 190
        if avg_miles_per_week_absolute >= 900 and avg_miles_per_week_absolute < 1500:
            amount_due = num_weeks_absolute * 190 + 100
        else:
            amount_due = num_weeks_absolute * 390 + ((avg_miles_per_week_absolute - 1500) * 0.25)

    #display the final output
    print("\nCustomer Summary:")
    print("\tClassification code: ", customer_code)
    print("\tDays rented: ", days)
    print("\tStarting Odometer: ", raw_start_odometer)
    print("\tEnd Odometer: ", raw_end_odometer)
    print("\tNumber of miles driven: ", round(miles_driven, 1))
    print("\tTotal amount due: $", round(amount_due, 2))

    should_continue = input("\nWould you like to continue (Y/N)? ")

#Print goodbye message if the user doesn't want to continue...
print("Thank you for your loyalty!")
