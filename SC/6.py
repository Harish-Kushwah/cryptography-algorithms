import numpy as np

# Step 1: Define input data (X) and expected outputs (Y)
# AND Gate Truth Table
X = np.array([
    [0, 0],
    [0, 1],
    [1, 0],
    [1, 1]
])

Y = np.array([0, 0, 0, 1])  # Expected outputs

# Step 2: Initialize weights and bias
weights = np.zeros(X.shape[1])  # two inputs → two weights
bias = 0
learning_rate = 0.1
epochs = 10  # how many times we train

# Step 3: Training using Perceptron Learning Rule
for epoch in range(epochs):
    print(f"\nEpoch {epoch+1}")
    for i in range(len(X)):
        # Calculate output
        linear_output = np.dot(X[i], weights) + bias
        prediction = 1 if linear_output >= 0 else 0

        # Calculate error
        error = Y[i] - prediction

        # Update weights and bias if wrong
        weights = weights + learning_rate * error * X[i]
        bias = bias + learning_rate * error

        print(f"Input: {X[i]} | Prediction: {prediction} | Error: {error} | Updated Weights: {weights}, Bias: {bias}")

# Step 4: Testing after training
print("\nFinal Results:")
for i in range(len(X)):
    linear_output = np.dot(X[i], weights) + bias
    prediction = 1 if linear_output >= 0 else 0
    print(f"Input: {X[i]} => Output: {prediction}")
