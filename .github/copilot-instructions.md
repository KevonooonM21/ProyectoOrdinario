# AI Agent Instructions for SistemaCobro Project

## Project Overview
A **parking fee calculation system** (Sistema de Cobro de Estacionamiento) built in Java using NetBeans. The system calculates parking charges based on vehicle type, duration, and applies configurable discounts. Desktop GUI built with Swing.

## Architecture

### Core Design Pattern: Strategy + Template Method
- **Vehiculo (Abstract)**: Base class defining the contract for all vehicles; implements `calcularTarifa(int horas)` as abstract template
- **Vehicle Types**: `Automovil`, `Camioneta`, `Motocicleta` - each extends Vehiculo and implements type-specific rate calculations
- **Descuento (Interface)**: Strategy pattern for discount types; implement `aplicarDescuento(double total)`
- **Concrete Discounts**: `DescuentoFrecuente` (15% fixed), `DescuentoPorHoras` (10% if >5 hours)
- **CalcularEstacionamiento**: Service class centralizing business logic (hours calculation, discount application, change calculation)

### Data Flow
```
Vehicle Instance + Entry/Exit Times 
  → CalcularEstacionamiento.calcularHoras()
  → CalcularEstacionamiento.totalSinDescuento()
  → CalcularEstacionamiento.aplicarDescuento() [optional]
  → CalcularEstacionamiento.totalFinal()
  → CalcularEstacionamiento.validarMonto() + calcularCambio()
```

## Key Conventions & Patterns

### Naming
- Spanish for domain concepts (horas, tarifa, estacionamiento)
- Mixed Spanish/English in code (e.g., "cargaPesada" boolean property)
- Getter/Setter pattern consistently used; note typo in Vehiculo: `settTarifaPorHora()` (double 't')

### Time Handling
- Uses `java.time.LocalTime` (24-hour format, expects "HH:mm" parsing)
- Handles overnight parking: if `salida.isBefore(entrada)`, adds 24 hours to exit time
- **Bug**: `calcularHoras()` method has incomplete implementation (missing return statement and Duration calculation)

### Discount Application
- Descuento interface enforces polymorphism; discounts are optional (null check in CalcularEstacionamiento)
- Discount percentages are hardcoded in implementations; consider refactoring to parameterized constructors if flexible rates needed

## Development Setup

### Build System
- **NetBeans IDE project** (nbproject/ folder with build-impl.xml)
- **Ant-based build** (build.xml) with standard targets: clean, compile, run, jar
- **Main class**: `SistemaCobro.ExamenFinal` (current GUI skeleton)
- **Manifest**: Auto-configures Main-Class during build

### Compilation & Execution
- Standard javac compilation; Swing requires no external JARs (JDK-bundled)
- Project properties in `nbproject/project.properties` control source/target Java version
- GUI entry point: ExamenFinal.main() - uses JFrame with basic button/label demo (incomplete)

## Critical Code Issues to Address
1. **CalcularEstacionamiento.calcularHoras()** - returns void; should return int (Duration.between calculation missing)
2. **Vehiculo.setTarifaPorHora()** - redundant method returning value (should be void setter)
3. **ExamenFinal GUI** - minimal proof-of-concept; needs integration with CalcularEstacionamiento logic
4. **No explicit error handling** for invalid time formats beyond IllegalArgumentException in calcularHoras

## Integration Points
- GUI (ExamenFinal) should instantiate vehicle + discount, call CalcularEstacionamiento methods, display results
- Vehicle subclasses override `calcularTarifa()` identically (no differentiation yet) - future: vehicle-type-specific multipliers
- Discount conditions (e.g., >5 hours threshold) currently hardcoded in DescuentoPorHoras; consider time-aware discount logic

## Testing Recommendations
- Unit test: CalcularEstacionamiento with various hour counts and discount combinations
- Edge case: overnight parking (22:00 to 02:00)
- Null discount scenario
- Invalid time format handling
