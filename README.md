# Elevator Simulation System

## Overview

This project is a Java-based simulation of an elevator system in a building with multiple floors and elevators. It models the behavior of elevators and simulates the interactions between the elevators and the people using them. The system aims to provide a realistic representation of elevator operations including moving between floors, handling passenger loads, and recording various statistics.

## Features

- **Multi-Floor Simulation**: Simulates elevators in a building with `N` floors.
- **Multiple Elevators**: Supports `M` identical elevators with specified capacities for passengers and weight.
- **Dynamic Passenger Generation**: Randomly generates passengers at each floor with varying weights and destination floors.
- **Statistical Data Collection**: Collects data such as total passengers, average waiting time, and average passenger weight.
- **User-Friendly Visualization**: Provides a visual interface to display the current state and statistics of the elevator system.

## System Parameters

- **Number of Floors (N)**: Specifies the total number of floors.
- **Number of Elevators (M)**: Specifies the total number of elevators.
- **Elevator Person Capacity (EPC)**: Maximum number of passengers an elevator can carry.
- **Elevator Weight Capacity (EWC)**: Maximum weight an elevator can carry.
- **Floor Wait Time (FWT)**: Time an elevator waits at a floor.
- **Floor Interval (FI)**: Time taken for an elevator to move between adjacent floors.
- **Person Patience (PP)**: Time a person waits for an elevator, varying between `PPMin` and `PPMax`.
