/* Basic styling for the weather monitoring system */
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 20px;
    max-width: 800px;
    width: 100%;
}

h1 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

.weather-data-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    gap: 20px;
}

.weather-card {
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 10px;
    width: 150px;
    text-align: center;
    background-color: #f9f9f9;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.refresh-button {
    display: block;
    margin: 20px auto 0;
    padding: 10px 20px;
    font-size: 16px;
    border: none;
    background-color: #007bff;
    color: #fff;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.refresh-button:hover {
    background-color: #0056b3;
}
