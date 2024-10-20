// List of cities to fetch weather data for
const cities = ['Delhi', 'Mumbai', 'Chennai', 'Bangalore', 'Kolkata', 'Hyderabad'];

// Function to fetch weather data for a specific city
async function fetchWeatherData(city) {
	console.log()
    try {
        const response = await fetch(`http://localhost:8875/weather/${city}`);
        console.log(`http://localhost:8875/weather/${city}`)
        if (!response.ok) {
            const errorData = await response.json(); // Get the error response
             console.log(errorData)
            throw new Error(`Could not fetch data for ${city}: ${errorData.message}`);
           
        }
        const data = await response.json();
        
        return { city, data };
    } catch (error) {
        console.error(error);
        return { city, error: error.message };
    }
}

// Function to refresh weather data for all cities
async function refreshWeather() {
    const weatherInfo = document.getElementById('weather-info');
    weatherInfo.innerHTML = ''; // Clear existing data

    for (const city of cities) {
        const result = await fetchWeatherData(city);
        const cityWeather = result.error ? `${city}: ${result.error}` : `${city}: ${result.data.main.temp} °C, ${result.data.weather[0].description}`;
        weatherInfo.innerHTML += `<p>${cityWeather}</p>`;
    }
}

// Initial call to display weather data
refreshWeather();
