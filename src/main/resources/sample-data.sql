-- Sample Data for Online Legal Case Management System

-- Insert Provinces
INSERT INTO province (name) VALUES 
('Central Province'),
('Western Province'),
('Southern Province');

-- Insert Districts
INSERT INTO district (name, province_id) VALUES 
('Colombo', 2),
('Kandy', 1),
('Galle', 3),
('Matara', 3);

-- Insert Clients
INSERT INTO client (name, email, phone, address, district_id) VALUES 
('John Doe', 'john@example.com', '0771234567', '123 Main St, Colombo', 1),
('Jane Smith', 'jane@example.com', '0779876543', '456 Temple Rd, Kandy', 2),
('Bob Wilson', 'bob@example.com', '0765432109', '789 Beach Rd, Galle', 3);

-- Insert Lawyers
INSERT INTO lawyer (name, email, phone, specialization, license_number, district_id) VALUES 
('Sarah Johnson', 'sarah@lawfirm.com', '0712345678', 'Criminal Law', 'LAW001', 1),
('Michael Brown', 'michael@lawfirm.com', '0723456789', 'Civil Law', 'LAW002', 1),
('Emily Davis', 'emily@lawfirm.com', '0734567890', 'Family Law', 'LAW003', 2);

-- Insert Legal Cases
INSERT INTO legal_case (case_number, title, description, case_type, status, filing_date, hearing_date, client_id) VALUES 
('CASE-2024-001', 'Property Dispute', 'Land ownership dispute between neighbors', 'Civil', 'Open', '2024-01-15', '2024-02-20', 1),
('CASE-2024-002', 'Divorce Case', 'Mutual consent divorce', 'Family', 'In Progress', '2024-01-20', '2024-03-10', 2),
('CASE-2024-003', 'Theft Case', 'Theft of personal property', 'Criminal', 'Open', '2024-01-25', '2024-02-28', 3);

-- Insert Case Assignments
INSERT INTO case_assignment (case_id, lawyer_id, assigned_date, role, status) VALUES 
(1, 2, '2024-01-16', 'Lead Attorney', 'Active'),
(2, 3, '2024-01-21', 'Lead Attorney', 'Active'),
(3, 1, '2024-01-26', 'Lead Attorney', 'Active');

-- Insert Users
INSERT INTO users (username, password, email, role, district_id) VALUES 
('admin', 'admin123', 'admin@system.com', 'ADMIN', 1),
('clerk1', 'clerk123', 'clerk1@system.com', 'CLERK', 1),
('clerk2', 'clerk123', 'clerk2@system.com', 'CLERK', 2);
