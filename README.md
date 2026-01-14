# JMeter Property Loader Plugin

A JMeter plugin that dynamically loads properties from external `.properties` files at test runtime. Properties are
merged into JMeter's global property map, making them accessible throughout your test plan via `${__P(propertyName)}`
syntax.

## Features

- Load properties from external files without modifying `jmeter.properties`
- Supports both absolute and relative file paths (relative to JMeter base directory)
- File browser UI for easy property file selection
- Properties override existing values (last loaded wins)
- Useful for environment-specific configurations and test data management

## Installation

1. Build the plugin:
   ```bash
   mvn clean package
   ```
2. Copy the generated JAR from `target/` to `JMETER_HOME/lib/ext/`
3. Restart JMeter

## Usage

### 1. Add the Plugin to Your Test Plan

- Right-click on your Test Plan or Thread Group
- Add → Config Element → **Property File Loader**
- Use the file browser to select your `.properties` file

### 2. Create a Properties File

Example `secrets.properties`:

```properties
api.host=https://api.example.com
api.timeout=5000
test.username=testuser
```

### 3. Reference Properties in Your Test Plan

Use JMeter's property function syntax:

- **HTTP Request**: Server Name = `${__P(api.host)}`
- **User Parameters**: Username = `${__P(test.username)}`
- **Timers**: Timeout = `${__P(api.timeout)}`

### 4. Multiple Property Files

You can add multiple Property File Loader elements. If files define the same property, the last one loaded takes
precedence (execution order is top-to-bottom in the test plan).

## Acknowledgements

This project is originally based
on [JMeter Property File Reader](https://github.com/toilatester/jmeter-property-file-reader).