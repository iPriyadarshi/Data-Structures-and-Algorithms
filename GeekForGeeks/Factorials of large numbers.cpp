// https://www.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1

#include <vector>
using namespace std;

// Class to calculate factorial of large numbers
// Time Complexity: O(N * M) where N is the input number and M is the number of digits in N!
// Space Complexity: O(M) where M is the number of digits in N!

// - M depends on N, so expressing both in terms of N is often clearer:
// - The number of digits in N! is approximately O(N log N) (from Stirling’s approximation).
// - So you could write:
// Time Complexity: O((N**2 )* log N)
// Space Complexity: O(N * log N)

class Solution
{
public:
    // Helper function to multiply the current factorial array with a number
    // Parameters:
    // arr: vector storing digits of factorial
    // size: current size of the factorial number
    // multiplier: number to multiply with
    void multiply(vector<int> &arr, int &size, int multiplier)
    {
        int carry = 0;

        // Multiply each digit and handle carry
        for (int i = 0; i < size; i++)
        {
            int res = multiplier * arr[i] + carry;
            arr[i] = res % 10; // Store last digit
            carry = res / 10;  // Calculate carry for next iteration
        }

        // Handle remaining carry
        while (carry > 0)
        {
            arr[size] = carry % 10;
            carry = carry / 10;
            size++;
        }
    }

    // Function to calculate factorial of n
    // Returns vector containing digits of n! in correct order
    vector<int> factorial(int n)
    {
        // Initialize array with enough space for large factorials
        vector<int> arr(10000, 0);
        arr[0] = 1; // Base case: factorial starts with 1
        int size = 1;

        // Calculate factorial by multiplying numbers from 2 to n
        for (int multiplier = 2; multiplier <= n; multiplier++)
        {
            multiply(arr, size, multiplier);
        }

        // Reverse the digits to get correct order
        vector<int> result;
        for (int i = size - 1; i >= 0; i--)
        {
            result.push_back(arr[i]);
        }

        return result;
    }
};