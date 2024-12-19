import 'package:flutter/material.dart';

import 'package:intl/intl.dart';
import 'package:point_of_sale/model/PatientModel.dart';
import 'package:point_of_sale/service/PatientService.dart'; // Import for date formatting

class PatientPage extends StatefulWidget {
  const PatientPage({super.key});

  @override
  State<PatientPage> createState() => _PatientPageState();
}

class _PatientPageState extends State<PatientPage> {
  late Future<List<Patient>> futurePatient;
  Map<int, double> _elevations = {}; // Store individual elevations for each card

  @override
  void initState() {
    super.initState();
    futurePatient = PatientService().fetchRegister();
  }

  /// Function to calculate age in years, months, and days
  String calculateAge(String dob) {
    try {
      DateTime birthDate = DateFormat('yyyy-MM-dd').parse(dob);
      DateTime currentDate = DateTime.now();
      int years = currentDate.year - birthDate.year;
      int months = currentDate.month - birthDate.month;
      int days = currentDate.day - birthDate.day;

      if (days < 0) {
        months -= 1;
        days += DateTime(currentDate.year, currentDate.month, 0).day;
      }
      if (months < 0) {
        years -= 1;
        months += 12;
      }

      return '$years years, $months months, $days days';
    } catch (e) {
      return 'Invalid Date';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Patients Details',
          style: TextStyle(
            fontWeight: FontWeight.bold,
            fontSize: 22,
          ),
        ),
        centerTitle: true,
        flexibleSpace: Container(
          decoration: const BoxDecoration(
            gradient: LinearGradient(
              begin: Alignment.topLeft,
              end: Alignment.bottomRight,
              colors: [Colors.red, Colors.lightGreenAccent, Colors.yellow],
            ),
          ),
        ),
      ),
      body: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [Colors.blueAccent, Colors.cyanAccent],
          ),
        ),
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 10),
          child: FutureBuilder<List<Patient>>(
            future: futurePatient,
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return const Center(child: CircularProgressIndicator());
              } else if (snapshot.hasError) {
                return Center(
                  child: Text(
                    'Error: ${snapshot.error}',
                    style: const TextStyle(fontSize: 16, color: Colors.red),
                  ),
                );
              } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
                return const Center(
                  child: Text(
                    'No Patients Available',
                    style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                  ),
                );
              } else {
                return ListView.builder(
                  itemCount: snapshot.data!.length,
                  itemBuilder: (context, index) {
                    final patient = snapshot.data![index];

                    // Set default elevation if not set already
                    if (_elevations[index] == null) {
                      _elevations[index] = 8.0; // Default elevation
                    }

                    return MouseRegion(
                      onEnter: (_) {
                        // Increase elevation when mouse enters
                        setState(() {
                          _elevations[index] = 16.0; // Increase elevation on hover
                        });
                      },
                      onExit: (_) {
                        // Reset elevation when mouse exits
                        setState(() {
                          _elevations[index] = 8.0; // Return to default elevation
                        });
                      },
                      child: AnimatedContainer(
                        duration: const Duration(milliseconds: 200), // Smooth animation
                        curve: Curves.easeInOut,
                        child: Card(
                          elevation: _elevations[index] ?? 8.0, // Animate elevation
                          margin: const EdgeInsets.symmetric(vertical: 10),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(20),
                          ),
                          child: Padding(
                            padding: const EdgeInsets.all(16.0),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                  children: [
                                    Row(
                                      children: [
                                        const Icon(Icons.account_circle_rounded, color: Colors.blue, size: 30),
                                        const SizedBox(width: 10),
                                        Text(
                                          patient.name ?? 'Unnamed Patient',
                                          style: const TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18,
                                            color: Colors.black87,
                                          ),
                                        ),
                                      ],
                                    ),
                                    const Icon(Icons.more_vert, color: Colors.grey),
                                  ],
                                ),
                                const Divider(thickness: 1, color: Colors.grey),
                                const SizedBox(height: 10),
                                Row(
                                  children: [
                                    const Icon(Icons.person, color: Colors.blue),
                                    const SizedBox(width: 10),
                                    Text(
                                      'ID: ${patient.id ?? 'No ID'}',
                                      style: const TextStyle(fontSize: 16),
                                    ),
                                  ],
                                ),
                                const SizedBox(height: 10),
                                Row(
                                  children: [
                                    const Icon(Icons.date_range, color: Colors.green),
                                    const SizedBox(width: 10),
                                    Text(
                                      'Date of Birth: ${patient.dob ?? 'No DOB'}',
                                      style: const TextStyle(fontSize: 16),
                                    ),
                                  ],
                                ),
                                if (patient.dob != null) // Only show age if DOB is available
                                  Row(
                                    children: [
                                      const Icon(Icons.cake, color: Colors.orange),
                                      const SizedBox(width: 10),
                                      Text(
                                        'Age: ${calculateAge(patient.dob!)}',
                                        style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                                      ),
                                    ],
                                  ),
                                const SizedBox(height: 10),
                                Row(
                                  children: [
                                    const Icon(Icons.phone, color: Colors.teal),
                                    const SizedBox(width: 10),
                                    Text(
                                      'Mobile: ${patient.mobile ?? 'No Mobile'}',
                                      style: const TextStyle(fontSize: 16),
                                    ),
                                  ],
                                ),
                                const SizedBox(height: 10),
                                Row(
                                  children: [
                                    const Icon(Icons.male, color: Colors.deepPurple),
                                    const SizedBox(width: 10),
                                    Text(
                                      'Gender: ${patient.gender ?? 'No Gender'}',
                                      style: const TextStyle(fontSize: 16),
                                    ),
                                  ],
                                ),
                                const SizedBox(height: 10),
                                Row(
                                  children: [
                                    const Icon(Icons.location_on, color: Colors.red),
                                    const SizedBox(width: 10),
                                    Expanded(
                                      child: Text(
                                        'Permanent Address: ${patient.permanentAddress ?? 'No Address'}',
                                        style: const TextStyle(fontSize: 16),
                                        maxLines: 2,
                                        overflow: TextOverflow.ellipsis,
                                      ),
                                    ),
                                  ],
                                ),
                                const SizedBox(height: 10),
                                Row(
                                  children: [
                                    const Icon(Icons.location_city, color: Colors.redAccent),
                                    const SizedBox(width: 10),
                                    Expanded(
                                      child: Text(
                                        'Present Address: ${patient.presentAddress ?? 'No Address'}',
                                        style: const TextStyle(fontSize: 16),
                                        maxLines: 2,
                                        overflow: TextOverflow.ellipsis,
                                      ),
                                    ),
                                  ],
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    );
                  },
                );
              }
            },
          ),
        ),
      ),
    );
  }
}
