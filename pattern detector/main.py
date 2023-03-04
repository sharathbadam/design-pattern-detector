import os
from singleton import detect_singleton
from builder import detect_builder
from factory import detect_factory

java_dir = "java_files"

for filename in os.listdir(java_dir):
    if filename.endswith(".java"):
        filepath = os.path.join(java_dir, filename)
        print("Checking file:", filepath)
        if detect_singleton(filepath):
            print("\tSingleton pattern detected!")
        elif detect_builder(filepath):
            print("\tBuilder pattern detected!")
        elif detect_factory(filepath):
            print("\tFactory pattern detected!")
        else:
            print("\tNo pattern detected.")
