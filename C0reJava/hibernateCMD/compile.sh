#!/bin/zsh

# === Configuration ===
JAR_PATH="/Users/tamojeetpal/Documents/JavaDev/C0reJava/jars/*"

# === Compilation ===
echo "Compiling Java files..."
javac -cp ".:$JAR_PATH" -proc:full Student.java
javac -cp ".:$JAR_PATH" HibernateUtil.java
javac -cp ".:$JAR_PATH" Test.java

# === Result check ===
if [ $? -eq 0 ]; then
  echo "✅ Compilation successful!"
else
  echo "❌ Compilation failed!"
  exit 1
fi

