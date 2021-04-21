-- ############################################################################################# --

-- BASIC AUTH with token time declarationuser_role
-- ACCESS TOKEN VALIDITY = 300 SECOND
-- REFRESH TOKEN VALIDITY = 1800 SECOND
-- insert client details [clientId = test & clientSecret = temp]
INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 authorities, access_token_validity, refresh_token_validity)
VALUES ('test', '$2y$12$UwAI5aoUSkTDzIdRtZ/EZu.RloBYfb53r6c9PiyvxQ0bBcF4mO4l.',
        'read,write', 'password,refresh_token,client_credentials,authorization_code',
        'ROLE_TRUSTED_CLIENT', 300, 1800);


-- ##########################################################--
# -- USER ROLES ---  TO be inserted after initializing the database
#
# INSERT INTO auth_role(id, role_name, description)
# VALUES (1, 'ROLE_ADMIN', 'Admin User - Has permission to perform admin tasks');
#
# INSERT INTO auth_role(id, role_name, description)
# VALUES (2, 'ROLE_USER', 'CONSULTANT - Has no admin rights');