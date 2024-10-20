const cities = ["Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"]; 
const apiKey = "9f5e0b1bdb6bdb602ed0222f0d200e88"; // Replace with your OpenWeatherMap API key
const weatherContainer = document.getElementById("weatherContainer");
const refreshButton = document.getElementById("refreshButton");

async function fetchWeatherData(city) {
    const latLonUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`; // Fetching weather data with city name
    try {
        const response = await fetch(latLonUrl);
        if (!response.ok) {
            throw new Error(`Could not fetch data for ${city}`);
        }
        const data = await response.json();

        // Convert the timestamp to a human-readable date and time
        const date = new Date(data.dt * 1000);
        const formattedDate = date.toLocaleDateString();
        const formattedTime = date.toLocaleTimeString();

        return {
            city: data.name,
            temp: data.main.temp,
            feelsLike: data.main.feels_like, // Feels like temperature
            condition: data.weather[0].main,
            windSpeed: data.wind.speed, // Wind speed
            date: formattedDate,
            time: formattedTime,
        };
    } catch (error) {
        console.error(error.message);
        return null;
    }
}

async function displayWeather() {
    weatherContainer.innerHTML = ''; // Clear previous data
    for (const city of cities) {
        const weatherData = await fetchWeatherData(city);
        if (weatherData) {
            weatherContainer.innerHTML += `
                <div class="weather-card">
                    <h2>${weatherData.city}</h2>
                    <p>Date: ${weatherData.date}</p>
                    <p>Time: ${weatherData.time}</p>
                    <p>Temperature: ${weatherData.temp}°C</p>
                    <p>Feels Like: ${weatherData.feelsLike}°C</p>
                    <p>Condition: ${weatherData.condition}</p>
                    <p>Wind Speed: ${weatherData.windSpeed} m/s</p>
                </div>
            `;
        } else {
            weatherContainer.innerHTML += `
                <div class="weather-card">
                    <h2>${city}</h2>
                    <p>Weather data not available</p>
                </div>
            `;
        }
    }
}

// Call displayWeather when the page loads
window.onload = displayWeather;

// Add event listener for refresh button
refreshButton.addEventListener("click", displayWeather);
