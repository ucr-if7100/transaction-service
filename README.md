# Transaction service

## Requirements

- Java 17
- MySQL 8.0

## Environment Variables

It is important to ensure that the environment variables are properly configured before running the API. If you run automated tests, you must configure the variables for that setup.

How to configure environment variables in IntelliJ?
Below, you will find a list of the required environment variables to configure and run the API:

#### `DATABASE_URL`\*

The URL of the MySQL database to which the API will connect. It should follow the following format and replace the corresponding values: `jdbc:mysql://{db_host}:{db_port:3306}/{db_name}`

#### `DATABASE_USERNAME`\*

The username used to authenticate the database connection.

#### `DATABASE_PASSWORD`\*

The password used to authenticate the database connection.
 
#### `PORT`

The port on which the server will run. By default, it uses port `8085`.

#### `SHOW_SQL`

Indicates whether Hibernate should display the SQL queries generated in the console. By default, it uses the value `false`.


##### Note: \* required values.
