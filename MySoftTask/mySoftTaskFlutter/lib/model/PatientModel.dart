class Patient {
  int? id;
  String? name;
  String? dob;
  String? mobile;
  String? gender;
  String? presentAddress;
  String? permanentAddress;

  Patient(
      {this.id,
        this.name,
        this.dob,
        this.mobile,
        this.gender,
        this.presentAddress,
        this.permanentAddress});

  Patient.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    name = json['name'];
    dob = json['dob'];
    mobile = json['mobile'];
    gender = json['gender'];
    presentAddress = json['presentAddress'];
    permanentAddress = json['permanentAddress'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['name'] = this.name;
    data['dob'] = this.dob;
    data['mobile'] = this.mobile;
    data['gender'] = this.gender;
    data['presentAddress'] = this.presentAddress;
    data['permanentAddress'] = this.permanentAddress;
    return data;
  }
}