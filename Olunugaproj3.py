#This program computes and displays statistical descriptions of a dataset.
#This imports the statistics library.
import statistics
#This is the data we are working with.
ages=[13, 15, 16, 16, 19, 20, 20, 21, 22, 22, 25, 25, 25, 25, 30, 33, 33, 35, 35, 35, 35, 36, 40, 45, 46, 52, 70.]
#This coding section finds the mean, mode, median, standard deviation, variance, first and third quartile of the data.
print("The mean of the data is:", statistics.mean(ages))
print("The median of the data is:", statistics.median(ages),"The data's modality is bimodal.")
print("The mode of the data is:", statistics.mode(ages))
print("The variance of the data is:", statistics.variance(ages))
print("The Standard deviation of the data is:", statistics.stdev(ages))
print("The quantiles of the data are:", statistics.quantiles(ages))
#This code finds the midrange of the data
midrange = (min(ages)+max(ages))/2
#This code prints the midrange of the data
print("The midrange of the data is:", midrange)
#This code prints the five-number summary of the dataset.
print("The five number summary of the dataset includes: in the order of min, max, median, first, and third quartile: ",min(ages), max(ages),statistics.median(ages),statistics.quantiles(ages))
#Importing the matplot library to help plot the boxplot
import matplotlib.pyplot as plt
# This is the size the boxplot is drawn to.
fig = plt.figure(figsize=(9,7))
plt.boxplot(ages)
plt.show()
