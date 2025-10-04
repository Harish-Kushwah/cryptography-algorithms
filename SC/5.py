import numpy as np

def perceptron_learning(X, y, lr=0.1, epochs=10):
    weights = np.zeros(X.shape[1])
    bias = 0

    for _ in range(epochs):
        for i in range(len(X)):
            linear_output = np.dot(X[i], weights) + bias
            prediction = 1 if linear_output > 0 else 0
            error = y[i] - prediction

            weights += lr * error * X[i]
            bias += lr * error

    return weights, bias

# Example: AND gate
X = np.array([[0,0],[0,1],[1,0],[1,1]])
y = np.array([0,0,0,1])

weights, bias = perceptron_learning(X, y)
print("Learned weights:", weights)
print("Learned bias:", bias)

# Test
for x in X:
    print(f"Input: {x}, Output: {1 if np.dot(x, weights)+bias > 0 else 0}")
