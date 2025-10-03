import cryptocode
import hashlib
import base64

def encryption_decryption():
    msg = input("Enter text: ")
    key = input("Enter key: ")

    encrypted = cryptocode.encrypt(msg, key)
    print("Encrypted:", encrypted)

    decrypted = cryptocode.decrypt(encrypted, key)
    print("Decrypted:", decrypted)


def hashing():
    text = input("Enter text for hashing: ")

    md5_hash = hashlib.md5(text.encode()).hexdigest()
    sha256_hash = hashlib.sha256(text.encode()).hexdigest()

    print("MD5 Hash   :", md5_hash)
    print("SHA256 Hash:", sha256_hash)


def base64_encode_decode():
    text = input("Enter text for Base64 encoding: ")

    encoded = base64.b64encode(text.encode())
    print("Base64 Encoded:", encoded)

    decoded = base64.b64decode(encoded).decode()
    print("Base64 Decoded:", decoded)


def main():
    while True:
        print("\n===== Unit V – Cryptography Menu =====")
        print("1. Encrypt/Decrypt using cryptocode")
        print("2. Hashing (MD5, SHA256)")
        print("3. Base64 Encode/Decode")
        print("4. Exit")

        choice = input("Enter choice: ")

        if choice == "1":
            encryption_decryption()
        elif choice == "2":
            hashing()
        elif choice == "3":
            base64_encode_decode()
        elif choice == "4":
            print("Exiting...")
            break
        else:
            print("Invalid choice! Try again.")


if __name__ == "__main__":
    main()
