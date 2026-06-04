import { useState } from 'react'
import './App.css'

function App() {
  const [clicks, setClicks] = useState(0)
  const [number, setNumber] = useState(1)

  const handleClick = () => {
    const nextClicks = clicks + 1
    
    setClicks(nextClicks)
    
    if (nextClicks % 3 === 0) {
      setNumber((prev) => prev * 2)
    }
  }

  return (
    <main className="app">
      <h1>Click the button</h1>
      <div className="number-display">Number: {number}</div>
      <button type="button" onClick={handleClick}>
        Click me
      </button>
      <p>Button clicked {clicks} {clicks === 1 ? 'time' : 'times'}</p>
    </main>
  )
}

export default App
