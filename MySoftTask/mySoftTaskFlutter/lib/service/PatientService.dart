import 'package:http/http.dart' as http;
import 'dart:convert';

import 'package:point_of_sale/model/PatientModel.dart';






class PatientService {
  final String apiUrl = 'http://localhost:8087/api/reg/';

  Future<List<Patient>> fetchRegister() async {
    final response = await http.get(Uri.parse(apiUrl));

    if (response.statusCode == 200) {
      final List<dynamic> RegisterJson = json.decode(response.body);
      return RegisterJson.map((json) => Patient.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load Patient');
    }
  }

}
